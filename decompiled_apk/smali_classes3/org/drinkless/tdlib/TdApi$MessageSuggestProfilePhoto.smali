.class public Lorg/drinkless/tdlib/TdApi$MessageSuggestProfilePhoto;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSuggestProfilePhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4a9ee119


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16800
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16801
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;)V
    .locals 0
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 16791
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16792
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestProfilePhoto;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 16793
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16797
    const v0, -0x4a9ee119    # -8.3864E-7f

    return v0
.end method
