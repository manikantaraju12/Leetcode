class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(),nums.end());
        for(size_t i=0;i<nums.size();i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l=i+1;
            int h=nums.size()-1;
            while(l<h)
            {
                int cur=nums[i]+nums[l]+nums[h];
                if(cur==0)
                {
                   res.push_back ({nums[i], nums[l], nums[h]});
                   while (l < h && nums[l] == nums[l+ 1]) l++;
                   while (l < h && nums[h] == nums[h- 1]) h--;
                   l++;
                   h--;
                }
                else if(cur<0) l++;
                else h--;
            }
        } 
        return res;
    }
};