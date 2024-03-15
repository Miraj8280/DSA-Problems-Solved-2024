/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function (nums) {
  // Get the length of the input array
  const n = nums.length;

  // Initialize the result array with all elements set to 1
  const result = Array(n).fill(1);

  // Initialize product to 1
  let product = 1;

  // Calculate the product of elements to the left of each element
  for (let i = 0; i < n; i++) {
    // Update result[i] to include the product of elements to the left of nums[i]
    result[i] *= product;

    // Update the running product by multiplying with the current element
    product *= nums[i];
  }

  // Reset product to 1
  product = 1;

  // Calculate the product of elements to the right of each element
  for (let i = n - 1; i >= 0; i--) {
    // Update result[i] to include the product of elements to the right of nums[i]
    result[i] *= product;

    // Update the running product by multiplying with the current element
    product *= nums[i];
  }

  // Return the resulting array
  return result;
};
