import pandas as pd
import yfinance as yf

def fetch_prices(symbol: str, period: str = "1y") -> pd.DataFrame:
    """
    Fetch daily OHLCV data from Yahoo Finance via yfinance.
    Returns a DataFrame with a Date column (no timezone) and standard columns.
    """
    df = yf.download(symbol, period=period, interval="1d", auto_adjust=False, progress=False)

    if df is None or df.empty:
        raise ValueError(f"No data returned for symbol={symbol}")

    # Standardize
    df = df.reset_index()  # Date becomes a column
    df["Symbol"] = symbol

    # Keep the columns we care about
    keep = ["Symbol", "Date", "Open", "High", "Low", "Close", "Adj Close", "Volume"]
    df = df[keep]

    # Make Date plain date (no time)
    df["Date"] = pd.to_datetime(df["Date"]).dt.date

    return df


def main():
    symbol = "AAPL"
    df = fetch_prices(symbol, period="1y")

    print(df.head(10))
    print("\nRows:", len(df))
    print("Date range:", df["Date"].min(), "->", df["Date"].max())

    if isinstance(df.columns, pd.MultiIndex):
        df.columns = df.columns.get_level_values(0)
    out = f"{symbol}_prices.csv"
    
    df.to_csv(out, index=False)
    print(f"\nSaved to: {out}")


if __name__ == "__main__":
    main()