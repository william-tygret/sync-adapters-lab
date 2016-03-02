---
title: Sync Adapters Lab
type: lab
duration: "1:25"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Sync Adapters Lab

## Introduction

> ***Note:*** _This should be done in pairs._

In this lab, you will be setting up a sync adapter to get the latest stock prices from five companies of your choice using the [markitondemand Stock Quote REST API](http://dev.markitondemand.com/MODApis/). **Don't forget to set your return type as json.** After you retrieve the stock information for each company, Log the company name and last stock price in the console. For instance: "Alphabet Inc: $741.71"

There should be three buttons on the screen, one to manually perform the sync, another to set up an automatic sync every minute, and a third to set up the automatic sync for every 5 minutes.

Since you are working in groups, the work needs to be divided up into separate branches for each student. How you split up the work is your decision, but a suggestion might be to have one student work on the SyncAdapter itself while the other works on the remaining components. Use the code from the lesson as a guide.

## Exercise

#### Requirements

- Set up a working sync adapter
- Have a button to let the user manually sync the stocks
- Have a button to let the user automatically sync the stocks every minute
- Have a button to let the user automatically sync the stocks every 5 minutes

**Bonus:**
- Show the synced stocks on the screen (hint: There are multiple ways to do this. You can try looking up ContentObservers)

#### Starter code

Use your code from the lesson as a template.

#### Deliverable

An app that meets the above requirements.

## Additional Resources

- A link to [something useful](http://www.w3schools.com/jsref/dom_obj_all.asp)
- Extra relevant [resource for students](https://developer.mozilla.org/en-US/docs/Web/Events)
