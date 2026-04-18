.class public Lorg/drinkless/tdlib/TdApi$ChatEventTitleChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventTitleChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x43990ad2


# instance fields
.field public newTitle:Ljava/lang/String;

.field public oldTitle:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24084
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24085
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 24074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24075
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventTitleChanged;->oldTitle:Ljava/lang/String;

    .line 24076
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventTitleChanged;->newTitle:Ljava/lang/String;

    .line 24077
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24081
    const v0, 0x43990ad2

    return v0
.end method
