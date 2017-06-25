Problem statement:
I run a highly busy website and need to pull down my site for an hour
in order to apply some patches and maintenance of back end severs,
which means the website will be completely unavailable for an hour.

To perform this activity the primary lookout will be that shutdown outage
should be affected to least number of users. The games starts here:
We need to identify at what hour of the day the web traffic is least
for the website so that maintenance activity can be scheduled for that time.

There is an Apache web server log for each day which records the activities
happening on website. But those are huge files up to 5 GB each.


We are interested only in the date field i.e. [07/Mar/2014:22:12:28 -0800]
Solution: I need to consume log files of one month and run my code
which calculates the total number of hits for each hour of the day.
Hour which has the least number of hits is perfect for the downtime.
It is as simple as that!