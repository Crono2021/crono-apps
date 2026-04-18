.class public Lorg/drinkless/tdlib/TdApi$SendTextMessageDraft;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendTextMessageDraft"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7e749bfe


# instance fields
.field public chatId:J

.field public draftId:J

.field public forumTopicId:I

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45174
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45175
    return-void
.end method

.method public constructor <init>(JIJLorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "j9"    # J
    .param p6, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 45162
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45163
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SendTextMessageDraft;->chatId:J

    .line 45164
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SendTextMessageDraft;->forumTopicId:I

    .line 45165
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$SendTextMessageDraft;->draftId:J

    .line 45166
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$SendTextMessageDraft;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 45167
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45171
    const v0, 0x7e749bfe

    return v0
.end method
