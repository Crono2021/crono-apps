.class public Lorg/drinkless/tdlib/TdApi$ChatFolderName;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatFolderName"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x13b2c262


# instance fields
.field public animateCustomEmoji:Z

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24164
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24165
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Z)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "z8"    # Z

    .line 24154
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24155
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderName;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 24156
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderName;->animateCustomEmoji:Z

    .line 24157
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24161
    const v0, -0x13b2c262

    return v0
.end method
