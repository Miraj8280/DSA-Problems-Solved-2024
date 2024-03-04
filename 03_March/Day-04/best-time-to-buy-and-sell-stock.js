/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  // Initialize variables to store the maximum profit and minimum price
  let profitMax = 0;
  let minPrice = Number.MAX_SAFE_INTEGER;

  // Iterate through each price
  for (const price of prices) {
    // Update the minimum price if the current price is lower
    minPrice = Math.min(minPrice, price);

    // Update the maximum profit
    profitMax = Math.max(profitMax, price - minPrice);
  }

  // Return the maximum profit achievable
  return profitMax;
};
