class Solution:
    """
    @param cpdomains: a list cpdomains of count-paired domains
    @return: a list of count-paired domains
    """
    def subdomainVisits(self, cpdomains):
        # Write your code here
        if not cpdomains:
            return []
        res = {}
        for c in cpdomains:
            l = c.split(" ")
            count, names = int(l[0]), l[1].split('.')
            for i in range(len(names)):
                key = '.'.join(names[i:])
                if key not in res:
                    res[key] = count
                else:
                    res[key] += count
        output = []
        for key in res:
            output.append(str(res[key])+' ' +key)
        return output