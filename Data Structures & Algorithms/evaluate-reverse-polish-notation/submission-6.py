class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        result=0
        op=0
        for token in tokens:
            if token =='+':
                operand2=int(stack.pop())
                operand1=int(stack.pop())
                result=operand1+operand2
                stack.append(result)
                op=1
            elif token =='-':
                operand2=int(stack.pop())
                operand1=int(stack.pop())
                result=operand1-operand2
                stack.append(result)
                op=1
            elif token =='/':
                operand2=int(stack.pop())
                operand1=int(stack.pop())
                result=int(operand1/operand2)
                stack.append(result)
                op=1
            elif token =='*':
                operand2=int(stack.pop())
                operand1=int(stack.pop())
                result=operand1*operand2
                stack.append(result) 
                op=1           
            else:
                stack.append(token)
        if op==0:
            result=int(stack.pop())
        return result

