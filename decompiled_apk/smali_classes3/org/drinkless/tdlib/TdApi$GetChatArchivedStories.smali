.class public Lorg/drinkless/tdlib/TdApi$GetChatArchivedStories;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatArchivedStories"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Stories;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x50e16b78


# instance fields
.field public chatId:J

.field public fromStoryId:I

.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37225
    return-void
.end method

.method public constructor <init>(JII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I

    .line 37213
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37214
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatArchivedStories;->chatId:J

    .line 37215
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatArchivedStories;->fromStoryId:I

    .line 37216
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GetChatArchivedStories;->limit:I

    .line 37217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37221
    const v0, -0x50e16b78

    return v0
.end method
