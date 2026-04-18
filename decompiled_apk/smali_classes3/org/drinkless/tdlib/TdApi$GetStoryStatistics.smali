.class public Lorg/drinkless/tdlib/TdApi$GetStoryStatistics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStoryStatistics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StoryStatistics;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a964342


# instance fields
.field public chatId:J

.field public isDark:Z

.field public storyId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37556
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37557
    return-void
.end method

.method public constructor <init>(JIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "z8"    # Z

    .line 37545
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37546
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetStoryStatistics;->chatId:J

    .line 37547
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetStoryStatistics;->storyId:I

    .line 37548
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$GetStoryStatistics;->isDark:Z

    .line 37549
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37553
    const v0, 0x3a964342

    return v0
.end method
