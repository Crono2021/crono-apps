.class public Lorg/drinkless/tdlib/TdApi$GetChatMessageByDate;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatMessageByDate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3f557136


# instance fields
.field public chatId:J

.field public date:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25844
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25845
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 25834
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25835
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatMessageByDate;->chatId:J

    .line 25836
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatMessageByDate;->date:I

    .line 25837
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25841
    const v0, 0x3f557136

    return v0
.end method
