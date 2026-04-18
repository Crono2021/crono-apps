.class public Lorg/drinkless/tdlib/TdApi$ToggleSavedMessagesTopicIsPinned;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSavedMessagesTopicIsPinned"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5eacba34


# instance fields
.field public isPinned:Z

.field public savedMessagesTopicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33328
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33329
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33319
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSavedMessagesTopicIsPinned;->savedMessagesTopicId:J

    .line 33320
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSavedMessagesTopicIsPinned;->isPinned:Z

    .line 33321
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33325
    const v0, -0x5eacba34

    return v0
.end method
