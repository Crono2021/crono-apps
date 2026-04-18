.class public Lorg/drinkless/tdlib/TdApi$SetAccountTtl;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetAccountTtl"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x29ce58e8


# instance fields
.field public ttl:Lorg/drinkless/tdlib/TdApi$AccountTtl;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19374
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19375
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AccountTtl;)V
    .locals 0
    .param p1, "accountTtl"    # Lorg/drinkless/tdlib/TdApi$AccountTtl;

    .line 19365
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19366
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetAccountTtl;->ttl:Lorg/drinkless/tdlib/TdApi$AccountTtl;

    .line 19367
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19371
    const v0, 0x29ce58e8

    return v0
.end method
