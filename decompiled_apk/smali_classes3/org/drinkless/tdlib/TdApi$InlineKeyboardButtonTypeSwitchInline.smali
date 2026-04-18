.class public Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeSwitchInline;
.super Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineKeyboardButtonTypeSwitchInline"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x207a9cf5


# instance fields
.field public query:Ljava/lang/String;

.field public targetChat:Lorg/drinkless/tdlib/TdApi$TargetChat;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27104
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 27105
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$TargetChat;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "targetChat"    # Lorg/drinkless/tdlib/TdApi$TargetChat;

    .line 27094
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 27095
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeSwitchInline;->query:Ljava/lang/String;

    .line 27096
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeSwitchInline;->targetChat:Lorg/drinkless/tdlib/TdApi$TargetChat;

    .line 27097
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27101
    const v0, 0x207a9cf5

    return v0
.end method
