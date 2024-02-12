/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
  let n = nums.length;
  let count = 0;
  let majority = 0;

  for (let i = 0; i < n; i++) {
    if (count === 0) {
      majority = nums[i];
    }
    if (majority === nums[i]) {
      count++;
    } else {
      count--;
    }
  }

  return majority;
};
