.class public Lorg/drinkless/tdlib/TdApi$MessageChatChangeTitle;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatChangeTitle"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2c99bb41


# instance fields
.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16296
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16297
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 16287
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16288
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatChangeTitle;->title:Ljava/lang/String;

    .line 16289
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16293
    const v0, 0x2c99bb41

    return v0
.end method
