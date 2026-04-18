.class public Lorg/drinkless/tdlib/TdApi$ReportSupergroupAntiSpamFalsePositive;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportSupergroupAntiSpamFalsePositive"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1ec24fb8


# instance fields
.field public messageId:J

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30308
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30309
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 30298
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30299
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReportSupergroupAntiSpamFalsePositive;->supergroupId:J

    .line 30300
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ReportSupergroupAntiSpamFalsePositive;->messageId:J

    .line 30301
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30305
    const v0, -0x1ec24fb8

    return v0
.end method
