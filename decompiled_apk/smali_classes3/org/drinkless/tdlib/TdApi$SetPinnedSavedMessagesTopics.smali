.class public Lorg/drinkless/tdlib/TdApi$SetPinnedSavedMessagesTopics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetPinnedSavedMessagesTopics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xb9cb36c


# instance fields
.field public savedMessagesTopicIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19879
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 19869
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19870
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetPinnedSavedMessagesTopics;->savedMessagesTopicIds:[J

    .line 19871
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19875
    const v0, -0xb9cb36c

    return v0
.end method
