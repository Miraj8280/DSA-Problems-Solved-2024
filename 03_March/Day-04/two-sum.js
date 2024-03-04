/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    // Create a Map to store elements and their indices
    const map = new Map();

    // Iterate through the array 
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];

        // Check if the complement exists in the Map and the index is different
        if (map.has(complement) && map.get(complement) !== i) {
            // Return the indices of the two numbers
            return [i, map.get(complement)];
        }

        // Add the current element and its index to the Map
        map.set(nums[i], i);
    }

    // Return an empty array if no solution is found 
    return [];
};