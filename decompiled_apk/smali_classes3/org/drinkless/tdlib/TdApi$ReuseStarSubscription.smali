.class public Lorg/drinkless/tdlib/TdApi$ReuseStarSubscription;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReuseStarSubscription"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2e677441


# instance fields
.field public subscriptionId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18906
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18907
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 18897
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18898
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReuseStarSubscription;->subscriptionId:Ljava/lang/String;

    .line 18899
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18903
    const v0, 0x2e677441

    return v0
.end method
