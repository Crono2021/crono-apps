.class public Lorg/drinkless/tdlib/TdApi$UpdateTonRevenueStatus;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateTonRevenueStatus"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6d3af39a


# instance fields
.field public status:Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22196
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22197
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;)V
    .locals 0
    .param p1, "tonRevenueStatus"    # Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;

    .line 22187
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22188
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateTonRevenueStatus;->status:Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;

    .line 22189
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22193
    const v0, 0x6d3af39a

    return v0
.end method
