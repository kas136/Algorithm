class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int count = 0;
        boolean check = true;
        
        for(String i : skill_trees) {
        	count = 0;
        	check = true;
        	
        	for(int j = 0; j < i.length(); j++) {
        		if(skill.indexOf(i.charAt(j)) > count) {
        			check = false;
        			break;
        		}
        		else if(skill.indexOf(i.charAt(j)) == count)
        			count++;
        	}
        	
        	if(check == true)
        		answer++;
        }
        return answer;
    }
}
