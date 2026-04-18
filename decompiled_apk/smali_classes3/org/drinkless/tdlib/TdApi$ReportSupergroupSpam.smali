.class public Lorg/drinkless/tdlib/TdApi$ReportSupergroupSpam;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportSupergroupSpam"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5a6ea28


# instance fields
.field public messageIds:[J

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30328
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30329
    return-void
.end method

.method public constructor <init>(J[J)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "jArr"    # [J

    .line 30318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30319
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReportSupergroupSpam;->supergroupId:J

    .line 30320
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ReportSupergroupSpam;->messageIds:[J

    .line 30321
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30325
    const v0, -0x5a6ea28

    return v0
.end method
