class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
         unordered_map<string, vector<string>> anagramGroups;
    for (const string& word : strs) {
        string sortedWord = word;
        sort(sortedWord.begin(), sortedWord.end()); 
        anagramGroups[sortedWord].push_back(word);
    }
    vector<vector<string>> result;
    for (const auto& group : anagramGroups) {
        result.push_back(group.second);
    }

    return result;

    }
};