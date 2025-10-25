class Solution {
public:
    int evalRPN(vector<string>& t) {
        stack<int> st;
        int x1,x2;
        for (int i = 0; i < t.size(); i++)
        {
           if(t[i] != "+" && t[i] != "-"&& t[i] !="*" && t[i] != "/"){
             st.push(stoi(t[i]));
           }
           else if(t[i] == "+"){
                  x2=st.top();
                  st.pop();
                  x1=st.top();
                  st.pop();
                  st.push(x1+x2);
           }
              else if(t[i] == "-"){
                  x2=st.top();
                  st.pop();
                  x1=st.top();
                  st.pop();
                  st.push(x1-x2);
           }
              else if(t[i] == "*"){
                  x2=st.top();
                  st.pop();
                  x1=st.top();
                  st.pop();
                  st.push(x1*x2);
           }   else if(t[i] == "/"){
                  x2=st.top();
                  st.pop();
                  x1=st.top();
                  st.pop();
                  st.push(x1/x2);
           }
        }
       return st.top(); 
    }
};