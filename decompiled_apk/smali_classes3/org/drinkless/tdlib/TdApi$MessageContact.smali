.class public Lorg/drinkless/tdlib/TdApi$MessageContact;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageContact"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1e8ef3a6


# instance fields
.field public contact:Lorg/drinkless/tdlib/TdApi$Contact;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16386
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16387
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Contact;)V
    .locals 0
    .param p1, "contact"    # Lorg/drinkless/tdlib/TdApi$Contact;

    .line 16377
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16378
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageContact;->contact:Lorg/drinkless/tdlib/TdApi$Contact;

    .line 16379
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16383
    const v0, -0x1e8ef3a6

    return v0
.end method
