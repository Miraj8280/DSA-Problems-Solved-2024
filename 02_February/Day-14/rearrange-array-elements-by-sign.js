/**
 * @param {number[]} nums
 * @return {number[]}
 */
var rearrangeArray = function (nums) {
  const result = new Array(nums.length).fill(-1);
  let positive = 0;
  let negative = 1;

  for (const num of nums) {
    if (num > 0) {
      result[positive] = num;
      positive += 2;
    } else {
      result[negative] = num;
      negative += 2;
    }
  }

  return result;
};
