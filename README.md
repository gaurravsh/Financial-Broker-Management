# Financial-Broker-Management

This is a self learning project, build mainly upon Spring Boot. Please refer to project [wiki](https://github.com/gaurravsh/Financial-Broker-Management/wiki) for more details.

Different branches serve different purpose of learning. Check [wiki](https://github.com/gaurravsh/Financial-Broker-Management/wiki) for more details.

**Learning Objectives** :

1. Write well designed *REST APIs*.
2. Learn and implement JPA. Don't use a lot of hibernate, because hibernate is just a wrapper around JPA. JPA is forever.
3. Start by using *h2* as database, and then promote to some external RDBMS.
4. Implement spring security, starting by simple password based authentication to more secure LDAP and OAuth based authentication.

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
