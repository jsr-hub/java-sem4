package pkaccount.fd;
class FDAccount extends Account implements Interface{
int period;
FDAccount(int acno,int p,double dep)
{
super(acno,dep);
period=p;
}
double calc_interest()
{
return balance*period*fdrate/100;
}
void close()
{
balance+=calc_interest();
}
}
