.class public Lorg/drinkless/tdlib/TdApi$ChatBoostSourcePremium;
.super Lorg/drinkless/tdlib/TdApi$ChatBoostSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoostSourcePremium"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xed4eb


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9762
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatBoostSource;-><init>()V

    .line 9763
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 9753
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatBoostSource;-><init>()V

    .line 9754
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSourcePremium;->userId:J

    .line 9755
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9759
    const v0, 0xed4eb

    return v0
.end method
