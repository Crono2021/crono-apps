.class public final Landroidx/datastore/preferences/protobuf/ListValue$Builder;
.super Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;
.source "ListValue.java"

# interfaces
.implements Landroidx/datastore/preferences/protobuf/ListValueOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/datastore/preferences/protobuf/ListValue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder<",
        "Landroidx/datastore/preferences/protobuf/ListValue;",
        "Landroidx/datastore/preferences/protobuf/ListValue$Builder;",
        ">;",
        "Landroidx/datastore/preferences/protobuf/ListValueOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 297
    invoke-static {}, Landroidx/datastore/preferences/protobuf/ListValue;->access$000()Landroidx/datastore/preferences/protobuf/ListValue;

    move-result-object v0

    invoke-direct {p0, v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;-><init>(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    .line 298
    return-void
.end method

.method synthetic constructor <init>(Landroidx/datastore/preferences/protobuf/ListValue$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/datastore/preferences/protobuf/ListValue$1;

    .line 290
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/ListValue$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public addAllValues(Ljava/lang/Iterable;)Landroidx/datastore/preferences/protobuf/ListValue$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable<",
            "+",
            "Landroidx/datastore/preferences/protobuf/Value;",
            ">;)",
            "Landroidx/datastore/preferences/protobuf/ListValue$Builder;"
        }
    .end annotation

    .line 420
    .local p1, "values":Ljava/lang/Iterable;, "Ljava/lang/Iterable<+Landroidx/datastore/preferences/protobuf/Value;>;"
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->copyOnWrite()V

    .line 421
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/ListValue;->access$700(Landroidx/datastore/preferences/protobuf/ListValue;Ljava/lang/Iterable;)V

    .line 422
    return-object p0
.end method

.method public addValues(ILandroidx/datastore/preferences/protobuf/Value$Builder;)Landroidx/datastore/preferences/protobuf/ListValue$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Value$Builder;

    .line 407
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->copyOnWrite()V

    .line 408
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/ListValue;->access$600(Landroidx/datastore/preferences/protobuf/ListValue;ILandroidx/datastore/preferences/protobuf/Value$Builder;)V

    .line 409
    return-object p0
.end method

.method public addValues(ILandroidx/datastore/preferences/protobuf/Value;)Landroidx/datastore/preferences/protobuf/ListValue$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Value;

    .line 381
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->copyOnWrite()V

    .line 382
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/ListValue;->access$400(Landroidx/datastore/preferences/protobuf/ListValue;ILandroidx/datastore/preferences/protobuf/Value;)V

    .line 383
    return-object p0
.end method

.method public addValues(Landroidx/datastore/preferences/protobuf/Value$Builder;)Landroidx/datastore/preferences/protobuf/ListValue$Builder;
    .locals 1
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Value$Builder;

    .line 394
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->copyOnWrite()V

    .line 395
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/ListValue;->access$500(Landroidx/datastore/preferences/protobuf/ListValue;Landroidx/datastore/preferences/protobuf/Value$Builder;)V

    .line 396
    return-object p0
.end method

.method public addValues(Landroidx/datastore/preferences/protobuf/Value;)Landroidx/datastore/preferences/protobuf/ListValue$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Value;

    .line 368
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->copyOnWrite()V

    .line 369
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/ListValue;->access$300(Landroidx/datastore/preferences/protobuf/ListValue;Landroidx/datastore/preferences/protobuf/Value;)V

    .line 370
    return-object p0
.end method

.method public clearValues()Landroidx/datastore/preferences/protobuf/ListValue$Builder;
    .locals 1

    .line 432
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->copyOnWrite()V

    .line 433
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/ListValue;->access$800(Landroidx/datastore/preferences/protobuf/ListValue;)V

    .line 434
    return-object p0
.end method

.method public getValues(I)Landroidx/datastore/preferences/protobuf/Value;
    .locals 1
    .param p1, "index"    # I

    .line 332
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-virtual {v0, p1}, Landroidx/datastore/preferences/protobuf/ListValue;->getValues(I)Landroidx/datastore/preferences/protobuf/Value;

    move-result-object v0

    return-object v0
.end method

.method public getValuesCount()I
    .locals 1

    .line 322
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/ListValue;->getValuesCount()I

    move-result v0

    return v0
.end method

.method public getValuesList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/datastore/preferences/protobuf/Value;",
            ">;"
        }
    .end annotation

    .line 310
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    .line 311
    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/ListValue;->getValuesList()Ljava/util/List;

    move-result-object v0

    .line 310
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public removeValues(I)Landroidx/datastore/preferences/protobuf/ListValue$Builder;
    .locals 1
    .param p1, "index"    # I

    .line 444
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->copyOnWrite()V

    .line 445
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/ListValue;->access$900(Landroidx/datastore/preferences/protobuf/ListValue;I)V

    .line 446
    return-object p0
.end method

.method public setValues(ILandroidx/datastore/preferences/protobuf/Value$Builder;)Landroidx/datastore/preferences/protobuf/ListValue$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Value$Builder;

    .line 356
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->copyOnWrite()V

    .line 357
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/ListValue;->access$200(Landroidx/datastore/preferences/protobuf/ListValue;ILandroidx/datastore/preferences/protobuf/Value$Builder;)V

    .line 358
    return-object p0
.end method

.method public setValues(ILandroidx/datastore/preferences/protobuf/Value;)Landroidx/datastore/preferences/protobuf/ListValue$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Value;

    .line 343
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->copyOnWrite()V

    .line 344
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ListValue$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/ListValue;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/ListValue;->access$100(Landroidx/datastore/preferences/protobuf/ListValue;ILandroidx/datastore/preferences/protobuf/Value;)V

    .line 345
    return-object p0
.end method
