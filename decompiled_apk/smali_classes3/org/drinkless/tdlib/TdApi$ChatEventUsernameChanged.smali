.class public Lorg/drinkless/tdlib/TdApi$ChatEventUsernameChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventUsernameChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6707b56b


# instance fields
.field public newUsername:Ljava/lang/String;

.field public oldUsername:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24104
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24105
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 24094
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24095
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventUsernameChanged;->oldUsername:Ljava/lang/String;

    .line 24096
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventUsernameChanged;->newUsername:Ljava/lang/String;

    .line 24097
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24101
    const v0, 0x6707b56b

    return v0
.end method
