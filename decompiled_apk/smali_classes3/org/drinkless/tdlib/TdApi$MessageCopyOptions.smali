.class public Lorg/drinkless/tdlib/TdApi$MessageCopyOptions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageCopyOptions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x405c03ba


# instance fields
.field public newCaption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public newShowCaptionAboveMedia:Z

.field public replaceCaption:Z

.field public sendCopy:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44166
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44167
    return-void
.end method

.method public constructor <init>(ZZLorg/drinkless/tdlib/TdApi$FormattedText;Z)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p4, "z10"    # Z

    .line 44154
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44155
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$MessageCopyOptions;->sendCopy:Z

    .line 44156
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$MessageCopyOptions;->replaceCaption:Z

    .line 44157
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageCopyOptions;->newCaption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 44158
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$MessageCopyOptions;->newShowCaptionAboveMedia:Z

    .line 44159
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44163
    const v0, 0x405c03ba

    return v0
.end method
