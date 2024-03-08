/**
 * @param {number[]} nums
 * @return {number}
 */
var maxFrequencyElements = function(nums) {
    const freq = new Map();

    for (const num of nums) {
        freq.set(num, (freq.get(num) || 0) + 1);
    }

    const maxFrequency = Math.max(...freq.values());

    const maxFreqElements = [...freq.keys()].filter(num => freq.get(num) === maxFrequency);

    const totalFrequency = maxFrequency * maxFreqElements.length;

    return totalFrequency;
};