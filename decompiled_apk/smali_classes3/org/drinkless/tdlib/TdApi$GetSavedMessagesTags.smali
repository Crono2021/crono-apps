.class public Lorg/drinkless/tdlib/TdApi$GetSavedMessagesTags;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetSavedMessagesTags"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$SavedMessagesTags;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x73299857


# instance fields
.field public savedMessagesTopicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13506
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13507
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13497
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13498
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetSavedMessagesTags;->savedMessagesTopicId:J

    .line 13499
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13503
    const v0, -0x73299857

    return v0
.end method
