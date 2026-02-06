# stock_prediction
This is a simple java project abot stock prediction using dynamic programming. A Java-based dynamic programming project that simulates optimal stock trading strategies under different real-world constraints such as transaction fees and cooldown periods.This repository focuses on algorithmic problem-solving, state-based DP modeling, and space/time optimization, commonly seen in competitive programming and technical interviews.
Features
This simulator supports multiple stock trading scenarios:
🔹 1. Unlimited Transactions
Buy and sell stocks any number of times
No transaction fee
No cooldown period
Classic 2-state DP (holding vs not holding)
🔹 2. Transactions with Fee
Each sell operation includes a fixed transaction fee
Optimized using constant space DP
Mimics real-world trading platforms
🔹 3. Transactions with Cooldown
One-day cooldown after selling before buying again
Uses three DP states: held, sold, and rest
Demonstrates advanced DP state transitions
