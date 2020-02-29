# Financial-Broker-Management

This is a self learning project, build mainly upon Spring Boot.

**Business Scenario** :
* There are people who have excess of money and can lend money to others to earn some interst, called *lenders*.
* There are people who need money and are searching for *lenders*, called *borrowers*.

Both of these are called *users*.

* A *broker* takes advantage of this situation and unites these *users*. In return, he gets some brokerage.

If *users* could know about each other, it would eliminate the need of a *broker*.
Hence, only a *broker* has authority to crack a deal between a *lender* and a *borrower*.

A *broker* would like to keep a track of all the deals he has made so far.
He also wants to get notified of which deals are going to expire and which *user* is due with amount (interest+principal). 

In a nutshell, this application is built around a *broker* to help him manage his business.

On top of all these people, there is an *admin*, which can be said as a DBA, who grants access to various *brokers* to use this sytem.
