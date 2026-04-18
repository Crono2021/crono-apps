.class public Lorg/drinkless/tdlib/TdApi$MessageGiveawayCreated;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageGiveawayCreated"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x39f3639f


# instance fields
.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16530
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16531
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 16521
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16522
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayCreated;->starCount:J

    .line 16523
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16527
    const v0, 0x39f3639f

    return v0
.end method
