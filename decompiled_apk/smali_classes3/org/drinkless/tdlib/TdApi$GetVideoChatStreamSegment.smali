.class public Lorg/drinkless/tdlib/TdApi$GetVideoChatStreamSegment;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetVideoChatStreamSegment"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Data;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2e1847f4


# instance fields
.field public channelId:I

.field public groupCallId:I

.field public scale:I

.field public timeOffset:J

.field public videoQuality:Lorg/drinkless/tdlib/TdApi$GroupCallVideoQuality;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47619
    return-void
.end method

.method public constructor <init>(IJIILorg/drinkless/tdlib/TdApi$GroupCallVideoQuality;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "i10"    # I
    .param p5, "i11"    # I
    .param p6, "groupCallVideoQuality"    # Lorg/drinkless/tdlib/TdApi$GroupCallVideoQuality;

    .line 47605
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47606
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetVideoChatStreamSegment;->groupCallId:I

    .line 47607
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$GetVideoChatStreamSegment;->timeOffset:J

    .line 47608
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GetVideoChatStreamSegment;->scale:I

    .line 47609
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetVideoChatStreamSegment;->channelId:I

    .line 47610
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$GetVideoChatStreamSegment;->videoQuality:Lorg/drinkless/tdlib/TdApi$GroupCallVideoQuality;

    .line 47611
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47615
    const v0, 0x2e1847f4

    return v0
.end method
