.class public Lorg/drinkless/tdlib/TdApi$GetCountries;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetCountries"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Countries;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x317f662


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2279
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 2284
    const v0, -0x317f662

    return v0
.end method
