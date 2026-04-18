.class public Lorg/drinkless/tdlib/TdApi$ChatEventDescriptionChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventDescriptionChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x254cf1e


# instance fields
.field public newDescription:Ljava/lang/String;

.field public oldDescription:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23745
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 23734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23735
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventDescriptionChanged;->oldDescription:Ljava/lang/String;

    .line 23736
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventDescriptionChanged;->newDescription:Ljava/lang/String;

    .line 23737
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23741
    const v0, 0x254cf1e

    return v0
.end method
