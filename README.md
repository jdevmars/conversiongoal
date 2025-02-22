This Spring Boot project is a demonstration of how to send the completion of a business goal to ExpertSender using its API (https://sites.google.com/expertsender.com/api-documentation-v2/methods/goal-fulfillment) for so.

The approach consists of sending a GUID along a newsletter in one of its links, a link that opens a web application where newsletters subscribers can simulate a purchase choosing up to 3 different possible values, supposing they are 3 different prices of distinct products. Once a price is chosen, over API, the web application sends to ExpertSender the goal completion associated with a given subscriber, bringing data to the different reports available in the platform.

The GUID uniquely identifies a subscriber, a message sent to it, the subscriber list to which the person is subscribed to, etc. This information needs to be passed along to the web application.

In the end, ExpertSender users can create segments of people who converted according to a bunch of possible rules available, selection of people who:

- have achieved a specific goal
- have achieved a specific goal in a particular message
- have achieved a specific goal in a parcitular messages with value inferior or superior to x
- have achieved a specific goal in a parcitular messages with value inferior or superior to x over the last y days
- etc.

It's something interesting, but on a daily basis, nearly no one makes use of conversion goals in ExpertSender.
