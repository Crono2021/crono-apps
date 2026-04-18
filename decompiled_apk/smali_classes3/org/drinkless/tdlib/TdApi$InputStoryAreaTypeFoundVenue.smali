.class public Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeFoundVenue;
.super Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputStoryAreaTypeFoundVenue"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x53325b6a


# instance fields
.field public queryId:J

.field public resultId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27464
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 27465
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 27454
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 27455
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeFoundVenue;->queryId:J

    .line 27456
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeFoundVenue;->resultId:Ljava/lang/String;

    .line 27457
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27461
    const v0, -0x53325b6a

    return v0
.end method
