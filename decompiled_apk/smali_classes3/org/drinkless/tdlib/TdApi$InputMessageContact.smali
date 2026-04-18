.class public Lorg/drinkless/tdlib/TdApi$InputMessageContact;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageContact"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3a8ef301


# instance fields
.field public contact:Lorg/drinkless/tdlib/TdApi$Contact;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14748
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 14749
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Contact;)V
    .locals 0
    .param p1, "contact"    # Lorg/drinkless/tdlib/TdApi$Contact;

    .line 14739
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 14740
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageContact;->contact:Lorg/drinkless/tdlib/TdApi$Contact;

    .line 14741
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14745
    const v0, -0x3a8ef301

    return v0
.end method
