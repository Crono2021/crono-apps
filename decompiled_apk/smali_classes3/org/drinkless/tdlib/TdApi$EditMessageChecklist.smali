.class public Lorg/drinkless/tdlib/TdApi$EditMessageChecklist;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditMessageChecklist"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x59477abc


# instance fields
.field public chatId:J

.field public checklist:Lorg/drinkless/tdlib/TdApi$InputChecklist;

.field public messageId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43159
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputChecklist;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p6, "inputChecklist"    # Lorg/drinkless/tdlib/TdApi$InputChecklist;

    .line 43146
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43147
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditMessageChecklist;->chatId:J

    .line 43148
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$EditMessageChecklist;->messageId:J

    .line 43149
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$EditMessageChecklist;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 43150
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditMessageChecklist;->checklist:Lorg/drinkless/tdlib/TdApi$InputChecklist;

    .line 43151
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43155
    const v0, 0x59477abc

    return v0
.end method
