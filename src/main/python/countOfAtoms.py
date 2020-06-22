import collections
class Solution:
    """
    @param formula: a string
    @return: return a string
    """
    def countOfAtoms(self, formula):
        # write your code here
        if not formula:
            return ""
        stack,l,i = [collections.Counter()],len(formula), 0
        while i < l:
            if formula[i] == '(':
                stack.append(collections.Counter())
                i += 1
            elif formula[i] == ')':
                top = stack.pop()
                i += 1
                i_start = i
                while i < l and formula[i].isdigit():
                    i += 1
                multi = int(formula[i_start:i] or 1)
                for name, v in top.items():
                    stack[-1][name] += v * multi
            else:
                i_start = i
                i += 1
                while i < l and formula[i].islower():
                    i += 1
                name = formula[i_start:i]
                i_start = i
                while i < l and formula[i].isdigit():
                    i += 1
                multi = int(formula[i_start:i] or 1)
                stack[-1][name] += multi
        result = ""
        for name in sorted(stack[-1]):
            result += name + (str(stack[-1][name]) if stack[-1][name] > 1 else "")
        return result