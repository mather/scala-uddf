# Memo about UDDF

Questions and Suggestions from me.

## General

- If compatibility between UDCF and UDDF or any version of UDDF, you need to specify namespace as fixed one.
- For any compatibility in future, I suggest to create converter for old UDDF. You can determine version by namespace.
- Keep examples testable.

## XML schema

See http://www.kohsuke.org/xmlschema/XMLSchemaDOsAndDONTs.html first. ( [日本語訳](http://www.horobi.com/xml/XMLSchemaDosAndDONTs.ja.html) )

## DateTime

- `<datetime>` is ambiguous because it can be any type of date, time or datetime. Set `xs:date` or `xs:time` or `xs:dateTime` strictly for each element.
    - So `encapsulateDateTimeType` is needless.
    - For example, `<issuedate>` is clearly `xs:date` type, so fix `<issuedate><datetime>2015-08-07</datetime></issuedate>` to `<issuedate>2015-08-07</issuedate>`.
- `<wreck><built><launchingdate>` is `xs:date` like, but `<wreck><sunk>` is `xs:dateTime` like. Any requirement to record time of sunk?
    - It should be same format as `xs:date`.
- `<dcalarmtime>` includes only "hour" and "minute", so `xs:time` (ignore seconds) or `<hour>23</hour><minute>59</minute>` is suitable for representation.

## Typo

- element name: `accomodation` -> `accommodation`
- enumeration: `"unknown "` -> `"unknown"`
