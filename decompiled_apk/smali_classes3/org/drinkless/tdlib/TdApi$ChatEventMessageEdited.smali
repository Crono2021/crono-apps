.class public Lorg/drinkless/tdlib/TdApi$ChatEventMessageEdited;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMessageEdited"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x19b00a08


# instance fields
.field public newMessage:Lorg/drinkless/tdlib/TdApi$Message;

.field public oldMessage:Lorg/drinkless/tdlib/TdApi$Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23984
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23985
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Message;Lorg/drinkless/tdlib/TdApi$Message;)V
    .locals 0
    .param p1, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p2, "message2"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 23974
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23975
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMessageEdited;->oldMessage:Lorg/drinkless/tdlib/TdApi$Message;

    .line 23976
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMessageEdited;->newMessage:Lorg/drinkless/tdlib/TdApi$Message;

    .line 23977
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23981
    const v0, -0x19b00a08

    return v0
.end method
