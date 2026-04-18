.class public Lorg/drinkless/tdlib/TdApi$GetSavedMessagesTopicMessageByDate;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetSavedMessagesTopicMessageByDate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3ea1b980


# instance fields
.field public date:I

.field public savedMessagesTopicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26664
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26665
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 26654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26655
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetSavedMessagesTopicMessageByDate;->savedMessagesTopicId:J

    .line 26656
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetSavedMessagesTopicMessageByDate;->date:I

    .line 26657
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26661
    const v0, -0x3ea1b980

    return v0
.end method
